
import { Provider } from "react-redux";
import { store } from "../store/store";
import type { AppProps } from "next/app";
import "swiper/swiper-bundle.css";
import "react-day-picker/style.css";
import "@/styles/customSwal.css";
import "@/styles/globals.css";

function MyApp({ Component, pageProps }: AppProps) {
  return (
      <Provider store={store}>
        <Component {...pageProps} />
      </Provider>
  );
}

export default MyApp;
