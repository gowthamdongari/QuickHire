import React from "react";
import { Link } from "react-router-dom";

const LandingPage = () => {
  return (
    <div>
      this is LandingPage
      <div>
        <Link to={"/SignIn"}>SignIn</Link>
      </div>
      <Link to={"/SignUp"}>SignUp</Link>
    </div>
  );
};

export default LandingPage;
