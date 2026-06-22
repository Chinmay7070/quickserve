import { useNavigate } from 'react-router-dom'
import '../../styles/Navbar.css'

const Navbar = () => {
  const navigate = useNavigate()

  return (
    <nav className="navbar">

      {/* Logo */}
      <div className="navbar-logo">
        <div className="logo-icon">
          <i className="fa-solid fa-bolt"></i>
        </div>
        <span className="logo-text">QuickServe</span>
      </div>

      {/* Nav Buttons */}
      <div className="navbar-buttons">
        <span className="nav-link">QuickServe Gold</span>
        <button className="btn-login" onClick={() => navigate('/login')}>
          Login
        </button>
        <button className="btn-register" onClick={() => navigate('/register')}>
          Create an account
        </button>
      </div>

    </nav>
  )
}

export default Navbar