import Navbar from '../../components/common/Navbar'
import '../../styles/LandingPage.css'

const LandingPage = () => {
  return (
    <div className="landing-page">

      
      <div className="dark-overlay"></div>

      
      <div className="accent-line"></div>

      
      <Navbar />

     
      <div className="hero-section">

        
        <div className="hero-left">

         
          <div className="hero-badge">
            <i className="fa-solid fa-award"></i>
            <span>India's #1 Restaurant Management Platform</span>
          </div>

        
          <h1 className="hero-heading">
            Manage the best <br />
            restaurants, cafés, <br />
            and bars in <br />
            <span className="hero-location">your city</span>
          </h1>

         
          <p className="hero-subtext">
            Streamline orders, automate payments, and deliver
            exceptional dining experiences from one powerful dashboard.
          </p>

         
          <div className="search-bar">
            <i className="fa-solid fa-magnifying-glass"></i>
            <input
              type="text"
              placeholder="Search for restaurants or cuisines"
            />
            <button className="search-btn">Search</button>
          </div>

         
          <div className="popular-tags">
            <span className="tag-label">Popular:</span>
            <span className="tag">
              <i className="fa-solid fa-pizza-slice"></i> Pizza
            </span>
            <span className="tag active">
              <i className="fa-solid fa-burger"></i> Burgers
            </span>
            <span className="tag">
              <i className="fa-solid fa-bowl-rice"></i> Biryani
            </span>
            <span className="tag">
              <i className="fa-solid fa-fish"></i> Sushi
            </span>
          </div>

          {/* Stats Row */}
          <div className="stats-row">
            <div className="stat-card">
              <p className="stat-number">500+</p>
              <p className="stat-label">Restaurants</p>
            </div>
            <div className="stat-card">
              <p className="stat-number">10K+</p>
              <p className="stat-label">Daily Orders</p>
            </div>
            <div className="stat-card orange">
              <p className="stat-number orange-text">
                4.9 <i className="fa-solid fa-star"></i>
              </p>
              <p className="stat-label">App Rating</p>
            </div>
            <div className="stat-card">
              <p className="stat-number">30 min</p>
              <p className="stat-label">Avg Delivery</p>
            </div>
          </div>

        </div>

        <div className="hero-right">

         
          <div className="glow-effect"></div>

          <div className="food-image-circle">
            <img
              src="https://images.unsplash.com/photo-1555939594-58d7cb561ad1?w=600&q=90"
              alt="food platter"
            />
          </div>

          <div className="float-card float-top">
            <div className="float-icon green">
              <i className="fa-solid fa-bag-shopping"></i>
            </div>
            <div>
              <p className="float-title">Order Placed!</p>
              <p className="float-sub">Just now</p>
            </div>
          </div>

          <div className="float-card float-bottom">
            <div className="float-icon orange">
              <i className="fa-solid fa-truck-fast"></i>
            </div>
            <div>
              <p className="float-title">Out for Delivery</p>
              <p className="float-sub">ETA: 20 mins</p>
            </div>
          </div>

          <div className="float-card float-rating">
            <p className="float-rating-number">
              <i className="fa-solid fa-star rating-star"></i> 4.9
            </p>
            <p className="float-sub">2,340 reviews</p>
          </div>

        </div>
      </div>

      <div className="scroll-hint">
        <div className="scroll-line"></div>
        <span className="scroll-text">SCROLL DOWN</span>
      </div>

    </div>
  )
}

export default LandingPage