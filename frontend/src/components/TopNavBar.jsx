import { Menu } from "lucide-react";
import React from "react";

const TopNavBar = () => {
  return (
    <div className="bg-white space-y-4  rounded-md sm:px-5 sm:py-3 lg:p-3 xl:px-6 xl:py-4">
      <div className="flex items-center justify-between border-b">
        <div className="mb-2">
          {/* Replace with your actual logo */}
          <img src="/assets/logo.png" alt="Logo" className="h-8 w-auto" />
        </div>
        <div className="text-gray shadow text-base font-bold ">
          <h2>Quick Hire</h2>
        </div>
        <div className="flex flex-row justify-center ">
          <div className="m-1">
            <img
              src="/assets/Profile-pic.jpg"
              alt="Profile"
              className="h-6 w-6 rounded-full"
            />
          </div>
          <div className="ml-1">
            <p className="text-sm font-semibold">Professional</p>
            <div className="text-xs text-gray-600">Developer</div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default TopNavBar;
