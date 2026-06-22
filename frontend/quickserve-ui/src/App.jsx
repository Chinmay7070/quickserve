import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom'
import LandingPage from './pages/auth/LandingPage'
import LoginPage from './pages/auth/LoginPage'
import RegisterPage from './pages/auth/RegisterPage'

const App = () => {
  return (
    <Router>
      <Routes>

        {/* Auth Routes */}
        <Route path="/" element={<LandingPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />

        {/* Unknown Route — Redirect to Landing */}
        <Route path="*" element={<Navigate to="/" />} />

      </Routes>
    </Router>
  )
}

export default App