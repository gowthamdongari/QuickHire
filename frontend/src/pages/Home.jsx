import React from 'react'
import { Outlet } from 'react-router-dom'
import SideNavBar from '../components/SideNavBar'
import TopNavBar from '../components/TopNavBar'

const Home = () => {
  return (
    <div> 
       <TopNavBar />
       <SideNavBar />
        <Outlet />
    </div>
  )
}

export default Home
