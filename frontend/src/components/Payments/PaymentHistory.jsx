import React from 'react'

function PaymentHistory() {
    const styles = {
        Username: {
          color: '#030303',
          fontSize: '24px',
          fontFamily: 'Source Sans Pro',
          fontWeight: 600,
          lineHeight: '36px',
        },
        ProfessionalDetails: {
            color: '#030303',
            fontSize: '24px',
            fontFamily: 'Source Sans Pro',
            fontWeight: 600,
            lineHeight: '36px',
            textAlign: 'center',
          },
          FirstName: {
            color: '#030303',
            fontSize: '12px',
            fontFamily: 'Source Sans Pro',
            fontWeight: 150,
            lineHeight: '23px',
          },
          Address: {
            color: '#858585',
            fontSize: '12px',
            fontFamily: 'Source Sans Pro',
            lineHeight: '23px',
          },
          Email: {
            color: '#858585',
            fontSize: '12px',
            fontFamily: 'Source Sans Pro',
            lineHeight: '23px',
          },
          PhoneNo: {
            color: '#858585',
            fontSize: '12px',
            fontFamily: 'Source Sans Pro',
            lineHeight: '23px',
          },
          Education: {
            color: '#030303',
            fontSize: '14px',
            fontFamily: 'Source Sans Pro',
            fontWeight: '500',
            lineHeight: '23px',
          },
          Card: {
            top: '470px',
            left: '304px',
            width: '300px',
            height: '200px',
            backgroundColor: '#ffffff',
            borderRadius: '24px',
            border: '1px solid #282828',
            boxSizing: 'border-box',
          },
          SmuHeading: {
            color: '#030303',
            fontSize: '14px',
            fontFamily: 'Source Sans Pro',
            fontWeight: 600,
            lineHeight: '36px',
          },
          SmuText: {
            color: '#858585',
            fontSize: '12px',
            fontFamily: 'Source Sans Pro',
            lineHeight: '23px',
          },
          Card2: {
            top: '1074px',
            left: '304px',
            width: '300px',
            height: '150px',
            backgroundColor: '#ffffff',
            borderRadius: '4px',
            border: '1px solid #282828',
            boxSizing: 'border-box',
          },
          Card3: {
            top: '1151px',
            left: '304px',
            width: '300px',
            height: '80px',
            backgroundColor: '#ffffff',
            borderRadius: '4px',
            border: '1px solid #282828',
            boxSizing: 'border-box',
          },
          PaymentPara: {
                color: '#000000',
                fontSize: '14px',
                fontFamily: 'Roboto',
                lineHeight: '31px',
          },
          Button: {
            cursor: 'pointer',
            top: '1322px',
            left: '840px',
            width: '221px',
            height: '57px',
            padding: '0px 8px',
            border: '0',
            boxSizing: 'border-box',
            backgroundColor: '#2f667f',
            color: '#ffffff',
            fontSize: '14px',
            fontFamily: 'Roboto',
            lineHeight: '24px',
            outline: 'none',
          },
    };
  return (
      <div>
        <div>
            <h1 style={styles.ProfessionalDetails}>Professional Details</h1>
        </div>
        <div>
            <h3 style={styles.Username}>User Name</h3>
        <div className='flex items-start'>
            <h5 style={styles.FirstName}>First Name</h5>
            <h5 style={styles.FirstName}>Last Name</h5>
        </div>
        <div>
            <h5 style={styles.Address}>Address: 5657, mcfarlein Blvd, Dallas, Texas, United States</h5>  
            <text style={styles.Email}>profesional@gmail.com</text> 
            <p style={styles.PhoneNo}>1234567890</p>
        </div>
        <div>
            <h5 style={styles.Education}>Education</h5>
            <div style={styles.Card} className='bg-white m-4 p-4 rounded-lg shadow-md'>
                <h5 style={styles.SmuHeading}>Southern Methodist University</h5>
                <p style={styles.SmuText}>Master of Science - Computer Enginering</p>
                <p style={styles.SmuText}>Aug 2023 - May 2025</p>
                <h5 style={styles.SmuHeading}>Southern Methodist University</h5>
                <p style={styles.SmuText}>Master of Science - Computer Enginering</p>
                <p style={styles.SmuText}>Aug 2023 - May 2025</p>
            </div>
        </div>
        <div>
            <h5 style={styles.Education}>Experience</h5>
            <div style={styles.Card} className='bg-white m-4 p-4 rounded-lg shadow-md'>
                <h5 style={styles.SmuHeading}>Google</h5>
                <p style={styles.SmuText}>'machnne learning enginer</p>
                <p style={styles.SmuText}>Aug 2020 - May 2021</p>
                <h5 style={styles.SmuHeading}>IBM</h5>
                <p style={styles.SmuText}>Quatum expert</p>
                <p style={styles.SmuText}>Aug 2023 - May 2025</p>
            </div>
        </div>
        
        <div style={styles.Card2} className='bg-white m-4 p-4 rounded-lg shadow-md'>
            <p style={styles.PaymentPara}>Payment Amount</p>
            <p style={styles.PaymentPara}>200 $</p>
            <p style={styles.PaymentPara}>Payment Status</p>
            <p style={styles.PaymentPara}>Done</p>
        </div>
        <div style={styles.Card3} className='bg-white m-4 p-4 rounded-lg shadow-md'>
            <p style={styles.PaymentPara}>Payment Date</p>
            <p style={styles.PaymentPara}>2/10/2024</p>            
        </div>
        <div className='m-4 flex items-center justify-center'>
        <button style={styles.Button}>Intiate Matching</button>
        </div>
        </div>
    </div>
  )
}
export default PaymentHistory
