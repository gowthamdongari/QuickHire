import { NavLink } from "react-router-dom";

const SideNavBar = () => {
  // write all the links here
 
 const staffLinks =[
  {
    title:"Professional Reviews",
    link:"/home/Professional?op=review"
  },
  {
    title:"Empolyee Reviews",
    link:"/home/Empolyee?op=review"
  },
  {
    title:"Professional lists",
    link:"/home/Professional?op=listing"
  },
  {
     title:"Empolyee Lists",
     link:"/home/Empolyee?op=listing"
  },
  {
    title:"Notifications",
    link:"/home/notifications"
  },
  {
    title:"Settings",
    link:"/home/Settings"
  }
 ]
  
 const employerLinks =[
     {
       title:"Create Job",
       link:"/home/JobPosting"
     }
 ]

  return (
    <aside>
      <div className="w-48 h-screen mt-2 ml-3 bg-gray-900 p-4 space-y-2">
        {/* Navigation links */}
        <nav>
          {/* Repeat this structure for each menu item */}
          {employerLinks.map((item) => {
            return (
              <NavLink
                to={item.link}
                key={item.link}
                className="flex items-center p-2 mt-2 text-xs text-white hover:bg-blue-200 rounded link"
              >
                {/* Use your icons library here */}
                <span className="ml-3">{item.title}</span>
              </NavLink>
            );
          })}

          {/* ... other nav items */}
        </nav>
      </div>
    </aside>
  );
};

export default SideNavBar;
