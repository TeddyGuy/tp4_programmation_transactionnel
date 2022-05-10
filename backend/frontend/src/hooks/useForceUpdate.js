import { useState } from "react";

const useForceUpdate = () => {
    const [value, setValue] = useState(0); 
    const increment = () => setValue((prev) => prev + 1);
    return [value, increment];
}

export default useForceUpdate;