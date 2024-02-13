import { color } from 'framer-motion'
import React from 'react'

const RegistrationPageProfessional = () => {
    const mystyle = {
        Header: {
        color: '#5856d6',
        fontsize: '48px',
        fontFamily: 'Roboto Slab',
        fontWeight: '500',
        lineHeight: '62px',
        textAlign: 'center',
        },

        Registration: {
            color: '#3a3a3a',
            fontSize: '40px',
            fontFamily: 'Source Sans Pro',
            fontWeight: 700,
            lineHeight: '56px',
            textAlign: 'center',
        },
        Para: {
            color: '#3a3a3a',
            fontSize: '18px',
            fontFamily: 'Source Sans Pro',
            lineHeight: '31px',
            textAlign: 'center',
        },
        Firstname: {
            color: '#3a3a3a',
            fontSize: '18px',
            fontFamily: 'Source Sans Pro',
            fontWeight: 500,
            lineHeight: '31px',
        },
        InputField: {
            top: '426px',
            left: '143px',
            width: '468px',
            height: '48px',
            padding: '0px 8px',
            border: '0',
            boxSizing: 'border-box',
            borderRadius: '24px',
            backgroundColor: '#f2f2f2',
            color: '#282828',
            fontSize: '14px',
            fontFamily: 'Source Sans Pro',
            fontWeight: 500,
            lineHeight: '18px',
            outline: 'none',
        },
        Button: {
            cursor: 'pointer',
            top: '1192px',
            left: '491px',
            width: '468px',
            height: '48px',
            padding: '0px 8px',
            border: '0',
            boxSizing: 'border-box',
            borderRadius: '24px',
            backgroundColor: '#e22823',
            color: '#ffffff',
            fontSize: '16px',

        }
    };
  return (
    <div>

      <h3 style={mystyle.Registration}>Professional Registration</h3>
      <p style={mystyle.Para}>Enter your company details to continue</p>
      <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
      <label style={mystyle.Firstname}>First Name</label>
      <input style={mystyle.InputField} placeholder='First Name'/>
      </div>
      <div class="w-full md:w-1/2 px-3">
      <label style={mystyle.Firstname}>Last Name</label>
      <input style={mystyle.InputField} placeholder='Last Name'/>
      </div>
      <label style={mystyle.Firstname}>Preferred Username</label>
      <input style={mystyle.InputField} placeholder='Preferred Username'/>
      <label style={mystyle.Firstname}>Email</label>
      <input style={mystyle.InputField} placeholder='Email'/>
      <label style={mystyle.Firstname}>Phone No</label>
      <input style={mystyle.InputField} placeholder='Phone no'/>
      <label style={mystyle.Firstname}>Mailling Address</label>
      <input style={mystyle.InputField} placeholder='Mailing Address'/>
      <label style={mystyle.Firstname}>City</label>
      <input style={mystyle.InputField} placeholder='City'/>
      <label style={mystyle.Firstname}>State</label>
      <input style={mystyle.InputField} placeholder='State'/>
      <label style={mystyle.Firstname}>Zipcode</label>
      <input style={mystyle.InputField} placeholder='Zipcode'/>
      <button style={mystyle.Button}>Register</button>
    </div>
  )
}

export default RegistrationPageProfessional
