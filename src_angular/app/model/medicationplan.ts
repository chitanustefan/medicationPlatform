import { Patient } from './patient';
import { Medicationperplan } from './medicationperplan';

export class Medicationplan {
    id_medication_plan: number;
    intake_intervals: string;
    period: string;
    patient: Patient;
    medicationPerPlans: Medicationperplan[];
    startPeriod: Date;
    finishPeriod: Date;
}
