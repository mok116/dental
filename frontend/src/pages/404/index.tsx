import React from 'react'
import Link from 'next/link';
import styles from "./NotFound.module.css";
import RootLayout from '@/layouts/RootLayout';
const NotFound : React.FC = () => {
  return (
    <RootLayout>
        <section>
            <div className={`${styles.notFoundContainer} container`}>
                <h1>404</h1>
                <p>The page you are looking for does not exist.</p>
                <Link href={"/"} className='btn-primary'>Return to homepage.</Link>
            </div>
        </section>
    </RootLayout>
  )
}

export default NotFound;