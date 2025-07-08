import React from "react";
import ExchangeRate from "../components/ExchangeRate.jsx";
import './ExchangeRateList.css'

const ExchangeRateList = (props) => {

    function getExchangeRateList(exchangeRateList) {
        return exchangeRateList.map((exchangeRate, index) => (
            <div className="col-12 col-sm-6 col-md-4 col-lg-3 mb-4" key={index}>
                <div className="ExchangeRate">
                    <ExchangeRate
                        classname={"ExchangeRate"}
                        exchangeRateData={exchangeRate}
                    />
                </div>
            </div>
        ));
    }

    return (
        <div className="container-fluid">
            <div className="row justify-content-center">
                {getExchangeRateList(props.exchangeRateList)}
            </div>
        </div>
    );
}

export default ExchangeRateList;