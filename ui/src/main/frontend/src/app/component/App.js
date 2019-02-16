import React from "react";
import HeaderPanel from "./header/HeaderPanel";
import LoginForm from "./LoginForm";

;

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      total: null,
      next: null,
      operation: null,
    };
  }

  render() {
    return (
      <div>
          <LoginForm/>
      </div>
    );
  }
}
export default App;
