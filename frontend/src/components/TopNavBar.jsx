import { Menu } from "lucide-react";
import React from "react";

const TopNavBar = () => {
  return (
    <div className="bg-white shadow p-2 w-full  flex">
      <div className="mb-4">
          {/* Replace with your actual logo */}
          <img src="/assets/logo.png" alt="Logo" className="h-10" />
        </div>
       <div>
          <h2>Quick hire</h2>
       </div>
      <div className="flex items-center ml-4">
        <img
          src="/assets/Profile-pic.jpg"
          alt="Profile"
          className="h-8 w-8 rounded-full"
        />
        <div >
          <p>Tom Cook</p>
          <div className="text-sm text-gray-500">Developer</div>
        </div>
      </div>
    </div>
  );
};

export default TopNavBar;
