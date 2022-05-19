import axios from "axios";
import React, { useState, useEffect } from "react";
import UsernameView from "./UsernameView";

export default function Usernames() {
    const [accounts, getAccounts] = useState("");
    const url = "http://localhost:8080/api/v1/";

    useEffect(() => {
        getAllAccounts();
    }, []);

    const getAllAccounts = () => {
        axios.get(`${url}account`)
            .then((response) => {
                const allAccounts = response.data;
                getAccounts(allAccounts);
            })
            .catch(error => console.error(`Error: ${error}`));
    }
    return (
        <UsernameView accounts={accounts} />
    )
}