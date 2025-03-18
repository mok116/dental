import React from "react";

const Logo: React.FC = () => (
  <svg
    width="300" // Increased from 202
    height="60" // Increased from 40
    viewBox="0 0 300 60"
    fill="none"
    xmlns="http://www.w3.org/2000/svg"
  >
    {/* Larger tooth shape with crown detail */}
    <path
      d="M30 15C30 8 37 2 45 2C53 2 60 8 60 15C60 22 56 28 50 30C44 32 38 30 35 28V15H55V15C55 10 51 6 45 6C39 6 35 10 35 15Z"
      fill="#007DFC" // Blue for professionalism
    />
    {/* Enhanced Hong Kong skyline/bauhinia curve */}
    <path
      d="M45 2C45 2 50 10 55 12C60 14 58 20 53 24C48 28 42 26 38 22C34 18 36 8 45 2Z"
      fill="#FFFFFF" // White for cleanliness
    />
    {/* Red accent lines for vibrancy */}
    <path
      d="M45 2V30M50 10H40"
      stroke="#FF0000" // Red for Hong Kong
      strokeWidth="2"
    />
    {/* Larger HKDC text */}
    <text
      x="80"
      y="40"
      fontFamily="Arial, sans-serif"
      fontSize="30" // Increased from 20
      fontWeight="bold"
      fill="#007DFC"
    >
      HKDC
    </text>
    {/* Subtext for full company name */}
    <text
      x="80"
      y="55"
      fontFamily="Arial, sans-serif"
      fontSize="12"
      fill="#333333" // Dark gray for contrast
    >
      Hong Kong Dental Care
    </text>
  </svg>
);

export default Logo;