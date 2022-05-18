import axios from "axios";
import React, { useState, useEffect } from "react";

export default function Usernames() {
    const [accounts, getAccounts] = useState("");
    const url = "localhost:8080/api/v1/"

    axios.get(`${url}account`)
        .then((response) => {
            const allAccounts = response.data.accounts.allAccounts;
            getAccounts(allAccounts)
        })
        .catch(error => console.error(`Error: ${error}`));
    return (
        <h1>{accounts.length}</h1>
    )
}