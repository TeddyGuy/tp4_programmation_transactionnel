import { Card, Button } from "react-bootstrap";
import CloseButton from 'react-bootstrap/CloseButton'

export const BookCard = ({book}) => {
    return(
        <>
            <Card className="m-auto mb-1" style={{ width: '19rem' }}>
                <Card.Body>
                    <Card.Title>
                        Livre: {book.title}
                    </Card.Title>
                    <Card.Text>
                        Auteur: {book.author} <br/>
                        Genre: {book.genre} <br/>
                        Année de publication: {book.publicationYear} <br/>
                        Pages: {book.pages} <br/>
                    </Card.Text>
                    <div className="d-flex justify-content-between">
                            <Button variant="warning">Modifier</Button> 
                            <CloseButton className="mt-3"/>
                    </div>
                </Card.Body>
                <Card.Footer>
                        Nombre d'exemplaires: {book.copies}
                </Card.Footer>
            </Card>
        </>
    );
}

export const DiscCard = ({disc}) => {
    return(
        <>
            <Card className="m-auto mb-1" style={{ width: '19rem' }}>
                <Card.Body>
                    <Card.Title>
                        {disc.type.toUpperCase()}: {disc.title}
                    </Card.Title>
                    <Card.Text>
                        Auteur: {disc.author} <br/>
                        Genre: {disc.genre} <br/>
                        Année de publication: {disc.publicationYear} <br/>
                        
                    </Card.Text>
                    <div className="d-flex justify-content-between">
                            <Button variant="warning">Modifier</Button> 
                            <CloseButton className="mt-3"/>
                    </div>
                </Card.Body>
                <Card.Footer>
                        Nombre d'exemplaires: {disc.copies}
                </Card.Footer>
            </Card>
        </>
    );
}