import React from "react";
import './ExchangeRate.css'

const ExchangeRate = (props) => {
    return (
        <div className="card">
            <div className="card-body">
                <h5 className="card-title">{props.shortName}</h5>
                <p className="card-text">{props.name} - {props.country}</p>
            </div>
        </div>
    );
}

export default ExchangeRate;
