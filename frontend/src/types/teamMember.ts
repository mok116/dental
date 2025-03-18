import { StaticImageData } from "next/image";

export default interface TeamMember {
  photoUrl: string | StaticImageData;
  name: string;
  title: string;
  resumeUrl: string;
  slug:string;
}
