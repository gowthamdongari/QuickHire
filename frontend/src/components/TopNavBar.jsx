import { Menu } from "lucide-react";
import React from "react";

const TopNavBar = () => {
  return (
    <div className="bg-white space-y-4 p-4 rounded-md sm:px-8 sm:py-6 lg:p-4 xl:px-8 xl:py-6">
      <div className="flex items-center justify-between border-b">
      <div className="mb-4">
          {/* Replace with your actual logo */}
          <img src="/assets/logo.png" alt="Logo" className="h-20" />
        </div>
       <div className="text-gray shadow text-lg font-bold ">
          <h2>Quick hire</h2>
       </div>
        <div className="flex flex-row justify-center ">
        <div className="m-2 p-2">
        <img
          src="/assets/Profile-pic.jpg"
          alt="Profile"
          className="h-8 w-8 rounded-full"
        />
        <div >
          <p>Professional</p>
          <div className="text-sm text-gray-500">Developer</div>
        </div>
      </div>
        </div>
        
      </div>
    </div>
  );
};

export default TopNavBar;
