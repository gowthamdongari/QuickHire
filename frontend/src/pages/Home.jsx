import React from 'react'
import { Outlet } from 'react-router-dom'
import SideNavBar from '../components/SideNavBar'
import TopNavBar from '../components/TopNavBar'

const Home = () => {
  return (
    <div className='w-full md:flex'> 
       <TopNavBar />
       <SideNavBar />
       <section>
        <Outlet />
       </section>
    </div>
  )
}

export default Home
