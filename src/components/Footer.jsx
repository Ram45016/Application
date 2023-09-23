import React from 'react';
import '../assets/css/Footer.css';

const Footer = () => {
  const footerLinks = ['Dashboard', 'Users', 'Contact Us', 'Settings'];

  return (
    <footer className="footer">
      <div className="footer-container">
        {footerLinks.map(link => (
          <div className="footer-section" key={link}>
            <ul>
              <li><a href="#" className="footer-link">{link}</a></li>
            </ul>
          </div>
        ))}
      </div>
    </footer>
  );
};

export default Footer;
