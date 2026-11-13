import React, { useState } from "react";
import { generateScanner } from "../services/scannerService";
import ScannerDisplay from "./ScannerDisplay";

function ScannerGenerator() {

  const [scanner, setScanner] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleGenerate = async () => {
    try {
      setLoading(true);
      setError("");

      const data = await generateScanner();

      setScanner(data);

    } catch (err) {
      setError(err.message || "Unable to generate scanner code");

    } finally {
      setLoading(false);
    }
  };

  return (
    <div>
      <button
        onClick={handleGenerate}
        disabled={loading}
      >
        {loading
          ? "Generating..."
          : "Generate Unique Scanner"}
      </button>

      {error && (
        <p className="error">
          {error}
        </p>
      )}

      <ScannerDisplay scanner={scanner} />
    </div>
  );
}

export default ScannerGenerator;