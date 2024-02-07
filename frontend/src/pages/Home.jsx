import React from "react";
import { Outlet } from "react-router-dom";
import SideNavBar from "../components/SideNavBar";
import TopNavBar from "../components/TopNavBar";

const Home = () => {
  return (
    <div className="max-h-screen flex flex-col">
      <TopNavBar />
      
    </div>
  );
};

export default Home;
