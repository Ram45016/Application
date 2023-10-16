    import React, { useState } from 'react';
    import '../assets/css/ArtistProfile.css'; // Assuming you have a separate CSS file
    import artist from '../assets/images/team member.jpg'
    function ArtistProfile() {
        const [showEditForm, setShowEditForm] = useState(false);
        const handleToggleEditForm = () => {
            setShowEditForm(prev => !prev);
        };
        return (
            <div className="artist-profile">

            <section className="header-section">
                <img src={artist} alt="Aria Smith" className="profile-image" />
                <div className="artist-title">
                    <h1>Aria Smith</h1>
                    <span>Visual Artist & Illustrator</span>
                </div>
            </section>

            <section className="about-section">
                <h2>About Me</h2>
                <p>Hello! I'm Aria, a visual artist based in Los Angeles...</p>
            </section>
            <section className="experience-section">
                <h2>Experience:</h2>
                <ul>
                    <li>2015-2023: Independent Visual Artist, Los Angeles.</li>
                    <li>2012-2015: Lead Illustrator, Artistic Studios, New York.</li>
                    <li>2010-2012: Junior Designer, Creative Designs Inc., San Francisco.</li>
                </ul>
            </section>
            <section className="exhibitions-section">

                <h2>Exhibitions:</h2>
                <ul>
                    <li>Solo Exhibition, Gallery Nova, London, 2020.</li>
                    <li>Group Exhibition, Artistic Horizons, Paris, 2019.</li>
                    <li>Digital Art Showcase, Modern Digital, Tokyo, 2017.</li>
                </ul>
            </section>

                <h2>Publications:</h2>
                <ul>
                    <li>"The Essence of Modern Art", Featured Artist, Art Monthly Magazine, June 2021.</li>
                    <li>"Exploring Digital Dimensions", Cover Artist & Interview, Digital World Magazine, January 2018.</li>
                </ul>
                <section className="publications-section">
                <h2>Education:</h2>
                <ul>
                    <li>Master of Fine Arts, New York Academy of Art, 2010.</li>
                    <li>Bachelor of Visual Arts, San Francisco State University, 2008.</li>
                </ul>
                
                </section>
                <section className="skills-section">
                <h2>Skills:</h2>
                <ul>
                    <li>Expertise in Oil Painting, Acrylics, and Watercolor.</li>
                    <li>Digital Art & Illustration.</li>
                    <li>Mural Design and Creation.</li>
                </ul>
                </section>

                <section className="commissions-section">
                <h2>Commissions & Collaborations:</h2>
                <p>
                    I'm available for private commissions, brand collaborations, and gallery exhibitions. 
                    To discuss potential projects or inquire about purchasing existing work, please <a href="mailto:aria_smith@email.com">contact me</a>.
                </p>
                </section>
                <section className="testimonials-section">
                <h2>Testimonials:</h2>
                <blockquote>
                    "Aria's work is breathtaking. Her ability to capture emotions in her paintings is unparalleled. A true master of her craft."
                    <footer>- Claire De Lune, Art Critic</footer>
                </blockquote>

                <blockquote>
                    "Collaborating with Aria was a delightful experience. Her professionalism and talent are evident in every piece she creates."
                    <footer>- John Doe, Author</footer>
                </blockquote>
                </section>
                <section className="social-media-section">
                <h2>Connect with Me</h2>
                <ul className="social-media-links">
                    <li><a href="instagram_link_here">Instagram</a></li>
                    <li><a href="twitter_link_here">Twitter</a></li>
                    <li><a href="artstation_link_here">ArtStation</a></li>
                </ul>
            </section>
            <button className="edit-profile-button" onClick={handleToggleEditForm}>
                Edit Profile
            </button>

            {showEditForm && (
                <div className="edit-profile-overlay">
                    <button className="close-edit-form" onClick={handleToggleEditForm}>✕</button>
                    <section className="edit-profile-form">
                        <h2>Edit Profile</h2>
                        <form>
    {/* Name */}
    <div className="form-group">
        <label>Name:</label>
        <input type="text" defaultValue="Aria Smith" />
    </div>

    {/* Title */}
    <div className="form-group">
        <label>Title:</label>
        <input type="text" defaultValue="Visual Artist & Illustrator" />
    </div>

    {/* About Me */}
    <div className="form-group">
        <label>About Me:</label>
        <textarea defaultValue="Hello! I'm Aria, a visual artist based in Los Angeles. I specialize in contemporary oil paintings and digital illustrations. With over 10 years of experience, I've had the privilege of exhibiting my works in various galleries globally, and collaborating with brands and authors for commissioned pieces."></textarea>
    </div>

    {/* Experience */}
    <div className="form-group">
        <label>Experience:</label>
        <textarea defaultValue="2015-2023: Independent Visual Artist, Los Angeles. 2012-2015: Lead Illustrator, Artistic Studios, New York. 2010-2012: Junior Designer, Creative Designs Inc., San Francisco."></textarea>
    </div>

    {/* Exhibitions */}
    <div className="form-group">
        <label>Exhibitions:</label>
        <textarea defaultValue="Solo Exhibition, Gallery Nova, London, 2020. Group Exhibition, Artistic Horizons, Paris, 2019. Digital Art Showcase, Modern Digital, Tokyo, 2017."></textarea>
    </div>

    {/* Publications */}
    <div className="form-group">
        <label>Publications:</label>
        <textarea defaultValue="The Essence of Modern Art, Featured Artist, Art Monthly Magazine, June 2021. Exploring Digital Dimensions, Cover Artist & Interview, Digital World Magazine, January 2018."></textarea>
    </div>

    {/* Education */}
    <div className="form-group">
        <label>Education:</label>
        <textarea defaultValue="Master of Fine Arts, New York Academy of Art, 2010. Bachelor of Visual Arts, San Francisco State University, 2008."></textarea>
    </div>

    {/* Skills */}
    <div className="form-group">
        <label>Skills:</label>
        <textarea defaultValue="Expertise in Oil Painting, Acrylics, and Watercolor. Digital Art & Illustration. Mural Design and Creation."></textarea>
    </div>

    {/* Commissions & Collaborations */}
    <div className="form-group">
        <label>Commissions & Collaborations:</label>
        <textarea defaultValue="I'm available for private commissions, brand collaborations, and gallery exhibitions. To discuss potential projects or inquire about purchasing existing work, please contact me."></textarea>
    </div>

    {/* Social Media */}
    <div className="form-group">
        <label>Instagram:</label>
        <input type="url" defaultValue="instagram_link_here" />
    </div>

    <div className="form-group">
        <label>Twitter:</label>
        <input type="url" defaultValue="twitter_link_here" />
    </div>

    <div className="form-group">
        <label>ArtStation:</label>
        <input type="url" defaultValue="artstation_link_here" />
    </div>

    <button type="submit">Save Changes</button>
</form>

                    </section>
                </div>
            )}
            </div>
        );
    }

    export default ArtistProfile;
