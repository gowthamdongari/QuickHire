"use client";

import { Sidebar } from "flowbite-react";
import { Link, NavLink } from "react-router-dom";
import { IoIosArrowBack } from "react-icons/io";
import { motion } from "framer-motion";
import { useEffect, useState } from "react";
import {useMediaQuery} from "react-responsive";

const SideNavBar = () => {
  let isTab = useMediaQuery({query:"(max-width:768px)"});
  const [isOpen, setIsOpen] = useState(isTab?false:true);
  const Sidebar_animate = isTab?{
    open: {
      x:0,
      width: "16rem",
      transition: {
        damping: 40,
      },
    },
    closed: {
      x:-250,
      width: 0,
      transition: {
        damping: 40,
        delay:0.15,
      },
    },
  }:{
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
  useEffect(()=>{
     if(isTab){
      setIsOpen(false);
     }else{
      setIsOpen(true);
     }
  },[isTab])
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
      
      <motion.div
        variants={Sidebar_animate}
        animate={isOpen ? "open" : "closed"}
        className="bg-white text-gray-5 shadow-xl z-[999] w-[16rem] max-w-[16rem] h-screen overflow-hidden md:relative fixed top-2"
      >
        <div className="flex flex-col h-full">
          <ul className="whitespace-pre px-2.5 text-[0.9rem] py-5 flex flex-col gap-1 font-medium overflow-x-hidden scrollbar-thin scrollbar-track-white ">
            <li >
            <NavLink to="/home/revie" className={"link"}>
                 Professional reviews
              </NavLink>
            </li>
            <li >
              <NavLink to="/home/review" className={"link"}>
                Empolyee reviews
              </NavLink>
            </li>
            {/* <li >
              <NavLink to="/home/individual" className={"link"}>
                 Individual
              </NavLink>
            </li> */}
            <li >
              <NavLink to="/home/notifcations" className={"link"}>
                  Notifications
              </NavLink>
            </li>
            <li >
              <NavLink to="/home/accountSettings" className={"link"}>
                  Account Settings
              </NavLink>
            </li>
          </ul>
        </div>

        <motion.div
          animate={
            isOpen
              ? {
                  x: 0,
                  y: 0,
                  rotate: 0,
                }
              : {
                  x: -10,
                  y: -200,
                  rotate: 180,
                }
          }
          transition={{
            duration: 0,
          }}
          onClick={() => setIsOpen(!isOpen)}
          className="absolute w-fit h-fit z-50 right-2 bottom-3 cursor-pointer md:block hidden"
        >
          <IoIosArrowBack size={25} />
        </motion.div>
      </motion.div>
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
