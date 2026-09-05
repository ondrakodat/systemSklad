export default function Header() {
    return <div>
    <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
            <div className="container-fluid">
                <ul className="navbar-nav">
                    <li className="nav-item">
                        <a className="nav-link active" href="#">Skladovy System 1.0.0</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#">Zamestnanci</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#">Produtky</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link disabled" href="#">TODO</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
}