'use client';

import { Sidebar } from 'flowbite-react';
import { HiArrowSmRight, HiChartPie, HiInbox, HiShoppingBag, HiTable, HiUser, HiViewBoards } from 'react-icons/hi';
import { Link } from 'react-router-dom';

const SideNavBar=() =>{
  const navsData =[
    {
      "title":"create",
      "id":1
    },
    {
      "title":"Review",
      "id":2
    }
  ]
  return (
    <Sidebar className='w-full md:w-56 bg-fbblue'>
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
    </Sidebar>
  );
}

export default SideNavBar;