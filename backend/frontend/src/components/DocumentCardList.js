import { BookCard, DiscCard } from "./DocumentCard";

const DocumentCardList = ({documents}) => {
    return(
    <>
        {documents.map(
            (document) => {
                if (document.type === 'book'){
                    return <BookCard key={document.id} book={document}/>
                }
                if (document.type === 'cd'|| document.type === 'dvd'){
                    return <DiscCard key={document.id} disc={document}/>
                }
            }
        )}
    </>
    );
}

export default DocumentCardList;