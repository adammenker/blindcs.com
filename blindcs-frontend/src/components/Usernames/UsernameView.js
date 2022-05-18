import React from "react";

export default function UsernameView(props) {

    const displayUsernames = (props) => {
        const { accounts } = props;

        if (accounts.length > 0) {
            return (
                accounts.map((account, index) => {
                    console.log(account);
                    return (
                        <div className="username" key={account._id}>
                            <h3>{account.username}</h3>
                        </div>
                    )
                })
            )
        } else {
            return (<h3>There are no users.</h3>)
        }
    }
    return (
        <>
            {displayUsernames(props)}
        </>
    )
}