import { useParams } from "react-router-dom";
import { Col, Row, Spinner } from "react-bootstrap";
import { useEffect, useState } from "react";
import axios from "axios";
import DocumentLoanCardList from "../components/DocumentLoansCardList";

const ClientBorrowingHistory = () => {
    const {id} = useParams();
    const[client, setClient] = useState({});
    const[documentLoans, setDocumentLoans] = useState([]);

    useEffect(() => {
        const getClient = async () => {
            const clientFromServer = await fetchClient();
            setClient(clientFromServer);
        }
        const getDocuments = async () => {
            const documentLoansFromServer = await fetchDocumentLoans();
            setDocumentLoans(documentLoansFromServer);
        }
        getDocuments();
        getClient();
    },[])

    const fetchClient = async () => {
        var clientFromServer;
        await axios.get("http://localhost:8080/clients/" + id).then((response) => {
            clientFromServer = response.data
        }); 
        return clientFromServer;
    }
    const fetchDocumentLoans = async () => {
        var documentLoansFromServer;
        await axios.get("http://localhost:8080/clients/" + id + "/borrowing-history").then((response) => {
            documentLoansFromServer = response.data
        }); 
        return documentLoansFromServer;
    }

    return(
        <>
            <h1 className="text-center">Historique d'emprunt de {client.firstName}, {client.lastName}</h1>
            <Row className="py-5 px-5">
                <Col>
                    <DocumentLoanCardList documentLoans={documentLoans}/>
                </Col>
                <Col>
                </Col>
            </Row>
        </>
    );
}

export default ClientBorrowingHistory;