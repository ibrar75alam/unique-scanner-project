import React from "react";
import { QRCodeSVG } from "qrcode.react";

function ScannerDisplay({ scanner }) {

  if (!scanner) {
    return null;
  }

  return (
    <div className="scanner-result">

      <h2>Scanner Generated Successfully</h2>

      <div className="qr-container">
        <QRCodeSVG
          value={scanner.scannerCode}
          size={150}
        />
      </div>

      <p>
        <strong>Scanner Code:</strong>
      </p>

      <p className="scanner-code">
        {scanner.scannerCode}
      </p>

      <p>
        <strong>Status:</strong> {scanner.status}
      </p>

      <p>
        <strong>Created At:</strong> {scanner.createdAt}
      </p>

    </div>
  );
}

export default ScannerDisplay;