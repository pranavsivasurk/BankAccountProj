import { useState, useEffect } from 'react'
import './App.css'

function App() {

  const [accounts, setAccounts] = useState([])

  
  async function getAccounts() {
    try {
      const response = await fetch('http://localhost:8080/GetAccounts')// Executes this get api call
      const data = await response.json()
      setAccounts(data)
    }
    catch (error) {
      console.log(error)
    }
  }

  // This allows the page to have the list of the current bank accounts whent the page loads
  useEffect(() => {
    getAccounts()
  }, [])

  return (
    <div>
      <h1>Bank Account Management System</h1>
      <h2>All Accounts</h2>

      {accounts.map(account => ( //Maps each data value to an html elements
        <div key={account.accountNumber}>
          <p>Account Name: {account.accountName}</p>
          <p>Account Number: {account.accountNumber}</p>
          <p>Account Type: {account.accountType}</p>
          <p>Balance: ${account.balance}</p>
          <hr />
        </div>
      ))}

    </div>
  )
}

export default App
