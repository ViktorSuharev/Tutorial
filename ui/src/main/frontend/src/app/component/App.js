import React from "react";

import LoginForm from "./LoginForm";

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            user: null
        };
    }

    signIn(username, password) {
        this.setState({
            user: {
                username,
                password,
            }
        });
    }

    signOut() {
        this.setState({user: null});
    }

    render() {
        return (
            <div>
                <h1>My cool App</h1>
                {
                    (this.state.user) ?
                        <Welcome
                            user={this.state.user}
                            onSignOut={this.signOut.bind(this)}
                        />
                        :
                        <LoginForm
                            onSignIn={this.signIn.bind(this)}
                        />
                }
            </div>
        )

    }

}

const Welcome = ({user, onSignOut})=> {
    return (
        <div>
            Welcome <strong>{user.username}</strong>!
            <a href="javascript:;" onClick={onSignOut}>Sign out</a>
        </div>
    )
};

export default App;