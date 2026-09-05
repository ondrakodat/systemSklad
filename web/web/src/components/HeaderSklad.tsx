import {NavLink} from "react-router-dom";

export default function Header() {
    return <div>
    <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
            <div className="container-fluid">
                <ul className="navbar-nav">

                    <li className="nav-item">
                        <NavLink to="/" className="nav-link active">
                            Skladový systém 1.0.0
                        </NavLink>
                    </li>

                    <li className="nav-item">
                        <NavLink to="/zamestnanci" className="active nav-link">
                            Zamestnanci
                        </NavLink>
                    </li>

                    <li className="nav-item">
                        <NavLink to="/produkty" className="active nav-link">
                            Produkty
                        </NavLink>
                    </li>

                    <li className="nav-item">
                        <a className="nav-link disabled" href="#">TODO</a>
                    </li>

                </ul>
            </div>
        </nav>
    </div>
}