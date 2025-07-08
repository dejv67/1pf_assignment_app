import { useState, useEffect } from "react";
import './App.css';
import ExchangeRateList from "./pages/ExchangeRateList.jsx";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Icon } from '@mdi/react';
import {mdiLoading} from '@mdi/js';

function App() {

    const [exchangeRateListCall, setExchangeRateListCall] = useState({
        state: "pending",
    });

    useEffect(() => {
        fetch(`https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e`, {
            method: "GET",
        }).then(async (response) => {
            const responseJson = await response.json();
            if (response.status >= 400) {
                setExchangeRateListCall({ state: "error", error: responseJson });
            } else {
                setExchangeRateListCall({ state: "success", data: responseJson });
            }
        }).catch(error => {setExchangeRateListCall({ state: "error", error: error })});
    }, []);

    function getExchangeRates() {
        switch (exchangeRateListCall.state) {
            case "pending":
                return (
                    <div className="loading">
                        <Icon size={2} path={mdiLoading} spin={true} color="white" />
                    </div>
                );
            case "success":
                return (
                    <>
                        <ExchangeRateList exchangeRateList={exchangeRateListCall.data} />
                    </>
                );
            case "error":
                return (
                    <div className="error">
                        <div>Nepodařilo se načíst data.</div>
                        <br />
                        <pre>{JSON.stringify(exchangeRateListCall.error, null, 2)}</pre>
                    </div>
                );
            default:
                return null;
        }
    }

    return (
        <div className="App">
            <h1 className="App-h1">
                Kurzovní lístky
            </h1>
            {getExchangeRates()}
        </div>
    )
}

export default App;
