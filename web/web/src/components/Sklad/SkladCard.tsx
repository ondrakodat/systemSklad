import { useEffect, useState } from "react";
import type { SkladDto } from "../../models/SkladDto.ts";
import { dejSkladPodleId } from "../../services/SkladService.ts";

type Props = {
    sklad: number;
};

export default function SkladCard({ sklad }: Props) {
    const [detailSkladu, setDetailSkladu] = useState<SkladDto>();

    useEffect(() => {
        async function nactiSklad() {
            const data = await dejSkladPodleId(sklad);
            setDetailSkladu(data);
        }

        nactiSklad();
    }, [sklad]);

    return (
        <div className="card" style={{ width: "18rem" }}>
            <div className="card-body">
                <h5 className="card-title">{detailSkladu?.nazev}</h5>
                <h6 className="card-subtitle mb-2 text-muted">
                    {detailSkladu?.mesto}
                </h6>

                <p className="card-text">
                    ID skladu: {detailSkladu?.id}
                </p>
            </div>
        </div>
    );
}