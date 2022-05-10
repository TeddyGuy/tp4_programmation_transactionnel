import { Card, Button } from "react-bootstrap";
import CloseButton from 'react-bootstrap/CloseButton'

const DocumentCard = ({document, setFormData, mode}) => {
    const sendDocumentInfoToForm = () => {
        const formData = {
            id:document.id,
            type:document.type,
            title:document.title,
            author:document.author,
            genre:document.genre,
            publisher:document.publisher,
            publicationYear:document.publicationYear,
            pages:document.pages,
            copies:document.copies
        }
        setFormData(formData);
    }

    return(
        <>
            <Card className="m-auto mb-1" style={{ width: '19rem' }}>
                <Card.Body>
                    <Card.Title>
                        {
                            document.type === 'book' ? 
                            <span>Livre: {document.title}</span> :
                            <span>{document.type.toUpperCase()}: {document.title}</span>
                        }
                    </Card.Title>
                    <Card.Text>
                        Auteur: {document.author} <br/>
                        Genre: {document.genre} <br/>
                        Année de publication: {document.publicationYear} <br/>
                        { document.type === 'book' && <span>Pages: {document.pages} <br/></span> }
                    </Card.Text>
                    {
                        mode === 'edit' &&
                        <div className="d-flex justify-content-between">
                            <Button variant="warning" onClick={sendDocumentInfoToForm}>Modifier</Button> 
                            <CloseButton className="mt-3"/>
                        </div>
                    }
                </Card.Body>
                {
                    mode === 'edit' &&
                    <Card.Footer>
                        Nombre d'exemplaires: {document.copies}
                    </Card.Footer>
                } 
            </Card>
        </>
    );
}

export default DocumentCard;