import React from "react";
import { Link } from "react-router-dom";
import TopNavBar from "../components/TopNavBar";

const LandingPage = () => {
  return (
    <div>
      <TopNavBar></TopNavBar>
      <div>
        <Link to={"/SignIn"}>SignIn</Link>
      </div>
      <Link to={"/SignUp"}>SignUp</Link>
    </div>
  );
};

export default LandingPage;
