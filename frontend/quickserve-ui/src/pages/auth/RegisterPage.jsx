import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import '../../styles/RegisterPage.css'

const RegisterPage = () => {

  const navigate = useNavigate()

  const [formData, setFormData] = useState({
    fullName: '',
    email: '',
    password: '',
    confirmPassword: '',
    role: 'RECEPTIONIST'
  })

  const [showPassword, setShowPassword] = useState(false)
  const [showConfirmPassword, setShowConfirmPassword] = useState(false)

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value })
  }

  const handleRoleSelect = (role) => {
    setFormData({ ...formData, role })
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    console.log(formData)
  }

  return (
    <div className="register-page">

      {/* Dark Overlay */}
      <div className="register-overlay"></div>

      {/* Orange Top Line */}
      <div className="register-accent-line"></div>

      {/* Navbar */}
      <nav className="register-navbar">
        <div className="register-logo">
          <div className="register-logo-icon">
            <i className="fa-solid fa-bolt"></i>
          </div>
          <span className="register-logo-text">QuickServe</span>
        </div>
        <div className="register-navbar-right">
          <span className="register-signin-text">Already have an account?</span>
          <button
            className="register-signin-btn"
            onClick={() => navigate('/login')}
          >
            Sign In
          </button>
        </div>
      </nav>

      {/* Center Form */}
      <div className="register-center">
        <div className="register-card">

          {/* Card Header */}
          <div className="register-card-header">
            <p className="register-card-label">Get Started</p>
            <h2 className="register-card-title">Create your account</h2>
            <p className="register-card-subtitle">Join 500+ restaurants on QuickServe</p>
          </div>

          {/* Form */}
          <form onSubmit={handleSubmit}>

            {/* 2 Column Grid */}
            <div className="register-form-grid">

              {/* Full Name */}
              <div className="register-input-wrap">
                <i className="fa-solid fa-user register-input-icon"></i>
                <input
                  className="register-input"
                  type="text"
                  name="fullName"
                  placeholder="Full Name"
                  value={formData.fullName}
                  onChange={handleChange}
                />
              </div>

              {/* Email */}
              <div className="register-input-wrap">
                <i className="fa-solid fa-envelope register-input-icon"></i>
                <input
                  className="register-input"
                  type="email"
                  name="email"
                  placeholder="Email Address"
                  value={formData.email}
                  onChange={handleChange}
                />
              </div>

              {/* Password */}
              <div className="register-input-wrap">
                <i className="fa-solid fa-lock register-input-icon"></i>
                <input
                  className="register-input"
                  type={showPassword ? 'text' : 'password'}
                  name="password"
                  placeholder="Password (min. 8)"
                  value={formData.password}
                  onChange={handleChange}
                />
                <i
                  className={`fa-solid ${showPassword ? 'fa-eye-slash' : 'fa-eye'} register-eye-icon`}
                  onClick={() => setShowPassword(!showPassword)}
                ></i>
              </div>

              {/* Confirm Password */}
              <div className="register-input-wrap">
                <i className="fa-solid fa-shield-halved register-input-icon"></i>
                <input
                  className="register-input"
                  type={showConfirmPassword ? 'text' : 'password'}
                  name="confirmPassword"
                  placeholder="Confirm Password"
                  value={formData.confirmPassword}
                  onChange={handleChange}
                />
                <i
                  className={`fa-solid ${showConfirmPassword ? 'fa-eye-slash' : 'fa-eye'} register-eye-icon`}
                  onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                ></i>
              </div>

            </div>

            {/* Role Selection */}
            <div className="register-role-section">
              <p className="register-role-label">I am a</p>
              <div className="register-role-cards">

                <div
                  className={`register-role-card ${formData.role === 'RECEPTIONIST' ? 'active' : ''}`}
                  onClick={() => handleRoleSelect('RECEPTIONIST')}
                >
                  <div className="register-role-icon orange">
                    <i className="fa-solid fa-headset"></i>
                  </div>
                  <div>
                    <p className="register-role-name">Receptionist</p>
                    <p className="register-role-desc">Manage orders</p>
                  </div>
                </div>

                <div
                  className={`register-role-card ${formData.role === 'CUSTOMER' ? 'active' : ''}`}
                  onClick={() => handleRoleSelect('CUSTOMER')}
                >
                  <div className="register-role-icon gray">
                    <i className="fa-solid fa-user"></i>
                  </div>
                  <div>
                    <p className="register-role-name">Customer</p>
                    <p className="register-role-desc">Track orders</p>
                  </div>
                </div>

              </div>
            </div>

            {/* Register Button */}
            <button type="submit" className="register-submit-btn">
              <span>Create Account</span>
              <i className="fa-solid fa-arrow-right"></i>
            </button>

          </form>

          {/* Divider */}
          <div className="register-divider">
            <div className="register-divider-line"></div>
            <span className="register-divider-text">or</span>
            <div className="register-divider-line"></div>
          </div>

          {/* Google Button */}
          <button className="register-google-btn">
            <i className="fa-brands fa-google"></i>
            <span>Continue with Google</span>
          </button>

          {/* Terms */}
          <p className="register-terms">
            By signing up, you agree to our{' '}
            <span className="register-link">Terms</span> &{' '}
            <span className="register-link">Privacy Policy</span>
          </p>

        </div>
      </div>

    </div>
  )
}

export default RegisterPage