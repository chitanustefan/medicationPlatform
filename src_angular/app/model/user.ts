import { Doctor } from './doctor';

export class User {

    id_user: number;
    name: string;
    email: string;
    password: string;
    birthday: Date;
    gender: string;
    role: string;
    id_patient: number;
    id_caregiver: number;
    id_doctor: Doctor;
}
