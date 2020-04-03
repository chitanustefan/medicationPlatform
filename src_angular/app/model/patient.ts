import { User } from './user';
import { Doctor } from './doctor';
import { Caregiver } from './caregiver';

export class Patient {

    id_patient: number;
    medicalRecord: string;
    caregiver: Caregiver;
    doctor: Doctor;
    user: User;
}
