// Smooth Scrolling
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({
                behavior: 'smooth',
                block: 'start'
            });
        }
    });
});

// Modal Functions
function openModal(certId) {
    const modal = document.getElementById('certificateModal');
    const modalBody = document.getElementById('modalBody');

    const certContent = {
        'cert1': `
            <h2>Full Stack Development Certificate</h2>
            <img src="https://via.placeholder.com/500x350/008080/ffffff?text=FNB+App+Academy+Certificate" alt="Certificate" style="width: 100%; border-radius: 5px; margin: 20px 0;">
            <div style="text-align: left;">
                <p><strong>Awarded by:</strong> FNB App Academy - IT Varsity</p>
                <p><strong>Program:</strong> Full Stack in Web Development</p>
                <p><strong>Date:</strong> 29 July 2025</p>
                <p><strong>Student Number:</strong> 6888D531AAC2D</p>
                <p><strong>Certificate Number:</strong> AOTYAA7025</p>
                <p style="margin-top: 20px;">This certificate is awarded for successful completion of the Full Stack in Web Development program, demonstrating proficiency in HTML5, CSS3, JavaScript, and modern web development frameworks.</p>
            </div>
        `,
        'autocad': `
            <h2>AutoCAD 3D Modelling Certification</h2>
            <img src="https://via.placeholder.com/500x350/008080/ffffff?text=AutoCAD+3D+Certificate" alt="Certificate" style="width: 100%; border-radius: 5px; margin: 20px 0;">
            <p>Advanced certification in AutoCAD 3D modeling, covering 3D solid modeling, surface modeling, visualization, and rendering techniques.</p>
        `,
        'revit': `
            <h2>Revit Reinforced Concrete Certification</h2>
            <img src="https://via.placeholder.com/500x350/008080/ffffff?text=Revit+Certificate" alt="Certificate" style="width: 100%; border-radius: 5px; margin: 20px 0;">
            <p>Certification in Revit for structural design, specializing in reinforced concrete structures, BIM workflows, and structural documentation.</p>
        `,
        'pm': `
            <h2>Project Management Certification</h2>
            <img src="https://via.placeholder.com/500x350/008080/ffffff?text=Project+Management" alt="Certificate" style="width: 100%; border-radius: 5px; margin: 20px 0;">
            <p>Certification in project management principles, including planning, scheduling, resource allocation, and project execution using Microsoft Project.</p>
        `,
        'literacy': `
            <h2>Computer Literacy Certification</h2>
            <img src="https://via.placeholder.com/500x350/008080/ffffff?text=Computer+Literacy" alt="Certificate" style="width: 100%; border-radius: 5px; margin: 20px 0;">
            <p>Comprehensive certification in Microsoft Office Suite including Word, Excel, PowerPoint, and Outlook, along with general computer operations.</p>
        `,
        'webdesign': `
            <h2>Introduction to Web Design and Development</h2>
            <img src="https://via.placeholder.com/500x350/008080/ffffff?text=Web+Design+Intro" alt="Certificate" style="width: 100%; border-radius: 5px; margin: 20px 0;">
            <p>Foundational certification in web design principles, user interface design, and basic web development technologies.</p>
        `,
        'fullstack': `
            <h2>Full Stack Development Award</h2>
            <img src="https://via.placeholder.com/500x350/008080/ffffff?text=Full+Stack+Award" alt="Certificate" style="width: 100%; border-radius: 5px; margin: 20px 0;">
            <p>Award for exceptional performance in the Full Stack Development program, recognizing mastery of both frontend and backend web technologies.</p>
        `
    };

    modalBody.innerHTML = certContent[certId] || '<p>Certificate information not available.</p>';
    modal.style.display = 'block';
}

function closeModal() {
    const modal = document.getElementById('certificateModal');
    modal.style.display = 'none';
}

// Close modal when clicking outside of it
window.onclick = function(event) {
    const modal = document.getElementById('certificateModal');
    if (event.target === modal) {
        modal.style.display = 'none';
    }
}

// Skill bars animation on scroll
const observerOptions = {
    threshold: 0.3,
    rootMargin: '0px 0px -100px 0px'
};

const skillObserver = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            const progressBars = entry.target.querySelectorAll('.skill-progress');
            progressBars.forEach(bar => {
                bar.style.width = bar.style.width || '0%';
            });
        }
    });
}, observerOptions);

document.querySelectorAll('.skill-category').forEach(category => {
    skillObserver.observe(category);
});

// Contact Form Handling
const contactForm = document.querySelector('.contact-form');
if (contactForm) {
    contactForm.addEventListener('submit', function(e) {
        e.preventDefault();

        const formData = new FormData(this);
        const name = formData.get('name');
        const email = formData.get('email');
        const message = formData.get('message');

        // Here you would typically send the form data to a server
        // For now, we'll just show an alert
        alert(`Thank you, ${name}! Your message has been received. I'll get back to you at ${email} soon.`);

        // Reset the form
        this.reset();
    });
}

// Add scroll effect to header
let lastScroll = 0;
const heroSection = document.querySelector('.hero');

window.addEventListener('scroll', () => {
    const currentScroll = window.pageYOffset;

    // Add parallax effect to hero
    if (currentScroll < window.innerHeight) {
        heroSection.style.opacity = 1 - currentScroll / 800;
    }

    lastScroll = currentScroll;
});

// Animate elements on scroll
const fadeObserver = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.style.opacity = '1';
            entry.target.style.transform = 'translateY(0)';
        }
    });
}, {
    threshold: 0.1
});

// Apply fade-in animation to sections
document.querySelectorAll('.timeline-item, .project-card, .cert-badge').forEach(el => {
    el.style.opacity = '0';
    el.style.transform = 'translateY(30px)';
    el.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
    fadeObserver.observe(el);
});

// Initialize on page load
window.addEventListener('load', () => {
    // Remove preloader if exists
    document.body.classList.add('loaded');
    
    // Display website URL in QR section
    const websiteUrlElement = document.getElementById('websiteUrl');
    if (websiteUrlElement) {
        const currentUrl = window.location.origin;
        websiteUrlElement.textContent = currentUrl;
    }
});
