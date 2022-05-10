import { BookCard, DiscCard } from "./DocumentCard";

const DocumentCardList = ({documents, setFormData}) => {
    return(
    <>
        {documents.map(
            (document) => {
                if (document.type === 'book'){
                    return <BookCard key={document.id} book={document} setFormData={setFormData}/>
                }
                if (document.type === 'cd'|| document.type === 'dvd'){
                   return <DiscCard key={document.id} disc={document} setFormData={setFormData}/>
                }
                return 'No model card available'
            }
        )}
    </>
    );
}

export default DocumentCardList;