# Dental Clinic Frontend

A modern, responsive dental clinic website built with Next.js, TypeScript, and CSS Modules.

## Features

- 🦷 **Online Appointment Booking**
  - Multi-step appointment form
  - Real-time availability checking
  - Appointment confirmation system

- 👤 **User Management**
  - User registration and login
  - Profile management
  - Appointment history tracking
  - Status monitoring for appointments

- 📱 **Responsive Design**
  - Mobile-first approach
  - Optimized for all devices
  - Smooth animations and transitions

- 🎨 **Modern UI Components**
  - Custom carousel
  - Multi-step forms
  - Interactive cards
  - Status indicators
  - Loading states

## Tech Stack

- **Framework**: Next.js
- **Language**: TypeScript
- **Styling**: CSS Modules
- **Icons**: React Icons
- **State Management**: React Hooks
- **Form Handling**: Custom validation

## Getting Started

### Prerequisites

- Node.js (v14 or higher)
- npm or yarn

### Installation

1. **Clone the repository**
   ```bash
   git clone [repository-url]
   cd dental/frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   # or
   yarn install
   ```

3. **Start the development server**
   ```bash
   npm run dev
   # or
   yarn dev
   ```

4. **Open the application**
   Open http://localhost:3000 in your browser

## Project Structure

```
frontend/
├── src/
│   ├── components/         # Reusable UI components
│   │   ├── carousel/      # Carousel component
│   │   ├── multistepform/ # Multi-step form component
│   │   ├── navbar/        # Navigation bar
│   │   └── ...
│   ├── pages/             # Next.js pages
│   │   ├── profile/       # User profile page
│   │   ├── get-appointment/ # Appointment booking
│   │   └── ...
│   ├── styles/            # Global styles and variables
│   └── utils/             # Utility functions
├── public/                # Static assets
└── package.json          # Project dependencies
```

## Available Pages

- `/` - Home page
- `/profile` - User profile and appointment history
- `/get-appointment` - Appointment booking
- `/treatments` - Available dental treatments
- `/contact` - Contact information
- `/login` - User login
- `/register` - User registration

## Development

### Code Style

- Follow TypeScript best practices
- Use CSS Modules for styling
- Implement responsive design
- Write clean, maintainable code

### Adding New Features

1. Create new components in the `components` directory
2. Add new pages in the `pages` directory
3. Update styles in the respective CSS modules
4. Test the feature across different devices

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request
