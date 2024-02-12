import { Menu } from "lucide-react";
import React from "react";

const TopNavBar = () => {
  return (
    <header className="flex gap-10 bg-violet lg:gap-20 justify-between pt-2 mb-6 mx-4">
        <div className="flex gap-4 items-center flex-shrink-0">
             <button >
              <Menu />
             </button>
             <p>
              <img 
              width="50px"
              height="50px"
              className="rounded"
               src="/assets/logo.png"
               alt="logo"
              />
               {/* img with height h-6 */}
             </p>
        </div>
        <div className="flex gap-4 flex-grow justify-center">
             <div className="flex flex-grow max-w-[600px]">
                   <h2 className="py-1 px-4 w-full">Quick Hire</h2>
              </div> 
        </div>
        <div className="flex flex-shrink-0 md:gap-2">
           <div>Username</div>
           <div>logout</div>
        </div>
    </header>
  );
};

export default TopNavBar;
