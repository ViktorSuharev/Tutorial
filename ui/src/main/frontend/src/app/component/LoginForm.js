import React from "react";
import * as axios from "axios";

class LoginForm extends React.Component {

    handleSignIn(e) {
        e.preventDefault();

        let name = this.refs.username.value;
        let password = this.refs.password.value;
        var user = new User(name, password);

        axios(`http://localhost:8090/auth/signin`, {
            method: 'POST',
            headers: {
                'content-type': 'application/json'
            },
            data: {user: user}
        })
    }

    render() {
        return (
            <form onSubmit={this.handleSignIn.bind(this)}>
                <h3>Sign in</h3>
                <input type="text" ref="username" placeholder="enter you username" />
                <input type="password" ref="password" placeholder ="enter password" />
                <input type="submit" value="Login" />
            </form>
        )
    }
}

export default LoginForm;

class User {
    constructor(name, password) {
        this.name = name;
        this.password = password;
    }
}