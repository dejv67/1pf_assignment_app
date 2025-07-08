import React, {useState} from "react";
import { Modal, Button } from 'react-bootstrap';
import './ExchangeRate.css'

const ExchangeRate = (props) => {
    const [show, setShow] = useState(false);

    return (
        <div className="card">
            <div className="card-body">
                <div className="d-flex align-items-center justify-content-between mb-1">
                    {/*preview*/}
                    <div>
                        <h5 className="card-title" style={{ display: 'inline' }}>{props.exchangeRateData.shortName}</h5>
                        <span className="text-muted"> ({props.exchangeRateData.name})</span>
                        <p className="card-text">{props.exchangeRateData.country}</p>
                    </div>

                    <Button variant="info" onClick={() => setShow(true)}>
                        Detail
                    </Button>

                    {/*detail*/}
                    <Modal show={show} onHide={() => setShow(false)} centered>
                        <Modal.Header closeButton>
                            <div>
                                <h5 className="card-title" style={{ display: 'inline' }}>{props.exchangeRateData.shortName}</h5>
                                <span className="text-muted">  ({props.exchangeRateData.name})</span>
                                <br />
                                <p className="card-text">{props.exchangeRateData.country}</p>
                            </div>
                        </Modal.Header>

                        <Modal.Body>
                            <div className="data-row">
                                <span className="label">Množství:</span>
                                <span className="value">{props.exchangeRateData.amount}</span>
                            </div>

                            <div className="data-row">
                                <span className="label">Změna:</span>
                                <span
                                    className={`value ${props.exchangeRateData.move > 0 ? 'text-success' : props.exchangeRateData.move < 0 ? 'text-danger' : ''}`}
                                >{props.exchangeRateData.move}
                                </span>
                            </div>

                            <div className="data-row">
                                <span className="label">Platné od:</span>
                                <span className="value">
                                    {new Date(props.exchangeRateData.validFrom).toLocaleDateString('cs-CZ')}
                                </span>
                                <span className="label">Verze:</span>
                                <span className="value">{props.exchangeRateData.version}</span>
                            </div>

                            <div className="rate-grid">
                                <div className="row-label"></div>
                                <div className="col-label">Střed</div>
                                <div className="col-label">Nákup</div>
                                <div className="col-label">Prodej</div>

                                <div className="label">Valuta:</div>
                                <div>{props.exchangeRateData.valMid}</div>
                                <div>{props.exchangeRateData.valBuy}</div>
                                <div>{props.exchangeRateData.valSell}</div>

                                <div className="label">Deviza:</div>
                                <div>{props.exchangeRateData.currMid}</div>
                                <div>{props.exchangeRateData.currBuy}</div>
                                <div>{props.exchangeRateData.currSell}</div>

                                <div className="label">Kurz ČNB:</div>
                                <div>{props.exchangeRateData.cnbMid}</div>
                                <div>-</div>
                                <div>-</div>

                                <div className="label">Kurz ECB:</div>
                                <div>{props.exchangeRateData.ecbMid}</div>
                                <div>-</div>
                                <div>-</div>
                            </div>
                        </Modal.Body>
                    </Modal>

                </div>
            </div>
        </div>

    );
}

export default ExchangeRate;
