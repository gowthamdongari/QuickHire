"use client";

import { Sidebar } from "flowbite-react";
import { Link, NavLink } from "react-router-dom";
import { IoIosArrowBack } from "react-icons/io";
import { motion } from "framer-motion";
import { useEffect, useState } from "react";
import { useMediaQuery } from "react-responsive";

const SideNavBar = () => {
  let isTab = useMediaQuery({ query: "(max-width:768px)" });
  const [isOpen, setIsOpen] = useState(isTab ? false : true);
  const Sidebar_animate = isTab
    ? {
        open: {
          x: 0,
          width: "16rem",
          transition: {
            damping: 40,
          },
        },
        closed: {
          x: -250,
          width: 0,
          transition: {
            damping: 40,
            delay: 0.15,
          },
        },
      }
    : {
        open: {
          width: "16rem",
          transition: {
            damping: 40,
          },
        },
        closed: {
          width: "4rem",
          transition: {
            damping: 40,
          },
        },
      };
  useEffect(() => {
    if (isTab) {
      setIsOpen(false);
    } else {
      setIsOpen(true);
    }
  }, [isTab]);
  const navsData = [
    {
      title: "create",
      id: 1,
    },
    {
      title: "Review",
      id: 2,
    },
  ];
  return (
    <aside>
      <div className="w-64 h-screen mt-2 ml-3 bg-white p-4 space-y-2">
        {/* Logo and Company name can go here */}
        
        {/* Navigation links */}
        <nav>
          {/* Repeat this structure for each menu item */}
          <a
            href="/dashboard"
            className="flex items-center p-2 hover:bg-gray-200 rounded"
          >
            {/* Use your icons library here */}
            <span className="ml-3">Dashboard</span>
          </a>
          {/* ... other nav items */}
        </nav>
      </div>
    </aside>
  );
};

export default SideNavBar;

{
  /* <Sidebar className='w-full md:w-56 bg-fbblue'>
      <Sidebar.Items>
          <Sidebar.ItemGroup className='flex flex-col gap-1'>
             {
              navsData.map((val)=>{
                return (
                  <Link key={val.id} to={`/home/${val.title}`}>
                    <Sidebar.Item>{val.title}</Sidebar.Item>
                  </Link>
                )
              })
             }
          </Sidebar.ItemGroup>
      </Sidebar.Items>
    </Sidebar> */
}
