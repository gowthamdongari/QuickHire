import React from "react";
import { Link, NavLink } from "react-router-dom";
const styles = {
  Card: {
    top: "89px",
    left: "0px",
    width: "264px",
    height: "1532px",
    backgroundColor: "#161616",
    border: "1px solid #282828",
    boxSizing: "border-box",
  },
};

const SideNavBar = () => {
  return (
    <aside className="fixed top-14 left-10 z-40 w-64 h-screen transition-transform -translate-x-full sm:translate-x-0">
      SideNavBar
    </aside>
  );
};

export default SideNavBar;




