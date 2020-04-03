import { Medicationperplan } from './medicationperplan';

export class Medication {

    id_medication: number;
    name: string;
    side_effect: string;
    dosage: string;
    medicationPerPlans: Medicationperplan[];
}
