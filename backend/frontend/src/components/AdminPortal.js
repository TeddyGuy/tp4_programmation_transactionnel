import { Col, Row, Spinner } from "react-bootstrap";
import axios from "axios";
import { useEffect, useState } from "react";
import DocumentCardList from "./DocumentCardList";
import DocumentForm from "./DocumentForm";

const AdminPortal = () => {
    const initialFormData = {
        id:'',
        title:'',
        type:'default',
        author:'',
        genre:'',
        publisher:'',
        publicationYear:0,
        pages:0,
        copies:1
    }
    const[documents, setDocuments] = useState([]);
    const[formData, setFormData] = useState(initialFormData);

    useEffect(()=>{
        const getDocuments = async () => {
            const documentsFromServer = await fetchDocuments();
            setDocuments(documentsFromServer);
        }
        getDocuments();
    },[formData]);

    const fetchDocuments = async () => {
        var documentsFromServer;
        await axios.get("http://localhost:8080/documents").then((response) => {
            documentsFromServer = response.data
        }); 
        return documentsFromServer;
    }

    const formHandler = (e) => {
        e.preventDefault();
        const form = e.currentTarget;

        if(!(form.checkValidity() && !form.querySelector("#type").className.includes("is-invalid"))) return;

        if(formData.id === ''){
            createDocument(formData);
        }
        else{
            updateDocument();
        }
    }

    const createDocument = async () => {
        await axios.post("http://localhost:8080/documents/" + formData.type + "s", formData);
        setFormData(initialFormData);
    }

    const updateDocument = () => {

    }

    return(
    <>
        <Row className="py-5 px-5">
            <Col>
                {
                    documents.length > 0 ?
                    <DocumentCardList documents={documents}/> :
                    <Spinner className='m-auto' animation="border" variant="warning"/>
                }
            </Col>
            <Col>
                <DocumentForm formData={formData} setFormData={setFormData} formHandler={formHandler}/>
            </Col>
        </Row>
    </>
    );
}

export default AdminPortal;